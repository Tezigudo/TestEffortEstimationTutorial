#!/bin/bash

# Directory to store logs
LOG_DIR="target/test-logs"

# Create log directory if it doesn't exist
if ! mkdir -p "$LOG_DIR"; then
    echo "Failed to create log directory. Check permissions and try again."
    exit 1
fi

# Run all tests and generate surefire reports
mvn clean test

# Check if surefire-reports directory exists
if [ ! -d "target/surefire-reports" ]; then
    echo "No test reports found. Make sure your tests are configured correctly."
    exit 1
fi

# Process each XML report
for xml_file in target/surefire-reports/TEST-*.xml; do
    # Extract test class name
    class_name=$(basename "$xml_file" .xml | sed 's/^TEST-//')

    # Process each test method in the XML file
    grep "<testcase " "$xml_file" | while read -r line; do
        # Extract method name
        method_name=$(echo "$line" | sed -n 's/.*name="\([^"]*\)".*/\1/p')

        # Extract test result (success or failure)
        if echo "$line" | grep -q "<failure"; then
            result="FAILED"
        else
            result="PASSED"
        fi

        # Create a safe filename
        safe_class_name=$(echo "$class_name" | tr '.' '_')
        safe_method_name=$(echo "$method_name" | tr '.' '_')

        # Count existing log files for this method
        existing_logs=$(ls -1 "${LOG_DIR}/log_${safe_class_name}_${safe_method_name}_N"*.log 2>/dev/null | wc -l)

        # Increment the count for the new log file
        new_count=$((existing_logs + 1))

        # Create log file
        log_file="${LOG_DIR}/log_${safe_class_name}_${safe_method_name}_N$(printf "%03d" $new_count).log"

        # Write test information to log file
        {
            echo "Test: $class_name#$method_name"
            echo "Result: $result"
            echo ""

            # If the test failed, extract and append the failure message
            if [ "$result" = "FAILED" ]; then
                failure_message=$(xmllint --xpath "string(//testcase[@name='$method_name']/failure/@message)" "$xml_file")
                echo "Failure message: $failure_message"
            fi

            # Append the console output for this test (if available)
            output_file="target/surefire-reports/${class_name}-output.txt"
            if [ -f "$output_file" ]; then
                echo "Console output:"
                echo "----------------"
                cat "$output_file"
            fi
        } > "$log_file"

        if [ $? -ne 0 ]; then
            echo "Failed to write to log file: $log_file"
            echo "Check permissions and available disk space."
            exit 1
        fi
    done
done

echo "Test logs have been collected in $LOG_DIR"