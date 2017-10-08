node {
    stage ("checkout") {
        git 'https://github.com/pei-wang/emailService.git'
    }

    stage ("build"){
        sh 'pwd'
        sh 'chmod a+x gradlew'
        sh './gradlew build'
    }

    stage ("deploy"){
        git 'https://github.com/pei-wang/pei-automation-jobs.git'
        dir('./') {
            sh 'ansible-playbook stop_email_service.yml'
            sh 'ansible-playbook java_deploy.yml'
        }
        sleep time: 1, unit: 'MINUTES'
        String appcheck = sh(
                script:'curl -sL -w "%{http_code}" localhost:10080/health -o /dev/null',
                returnStdout: true
        ).trim()
        if(appcheck == '200'){
            currentBuild.result='SUCCESS'
        }else{
            currentBuild.result='FAILURE'
        }
    }
}