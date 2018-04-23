pipeline {

	agent any
	
	tools {
		maven 'Maven 3.2.1'
	}
	
	stages {
		
		stage('test') {
		
			steps {
				sh 'mvn clean test'
			}
		}
	}
}