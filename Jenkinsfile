pipeline {
    agent any

    tools {
        // Use the Maven version installed in Jenkins
        maven 'Maven_3'
        // Optional: Use a JDK if needed
        jdk 'JDK_1.8'
    }

    environment {
        PROJECT_DIR = "${WORKSPACE}"
        REPORT_DIR = "${WORKSPACE}/target/cucumber-reports"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/ChandanKumarQA/practiceEcommerse'
            }
        }

        stage('Clean & Build') {
            steps {
                // Clean and compile project
                sh 'mvn clean compile'
            }
        }

        stage('Run Cucumber Tests') {
            steps {
                // Run all runner classes
                sh 'mvn test'
            }
        }

        stage('Publish Reports') {
            steps {
                // Archive HTML reports
                publishHTML(target: [
                    reportName: 'Cucumber HTML Report',
                    reportDir: "${REPORT_DIR}",
                    reportFiles: 'cucumber_register.html',
                    keepAll: true,
                    alwaysLinkToLastBuild: true,
                    allowMissing: false
                ])
                
                // Archive Extent Reports
                publishHTML(target: [
                    reportName: 'Extent Report',
                    reportDir: "${REPORT_DIR}",
                    reportFiles: 'extent.html',
                    keepAll: true,
                    alwaysLinkToLastBuild: true,
                    allowMissing: true
                ])
            }
        }
    }

    post {
        always {
            // Optional: Archive screenshots and logs
            archiveArtifacts artifacts: 'target/cucumber-reports/**/*.png', allowEmptyArchive: true
        }
        success {
            echo 'All tests executed successfully!'
        }
        failure {
            echo 'Some tests failed. Check reports for details.'
        }
    }
}
