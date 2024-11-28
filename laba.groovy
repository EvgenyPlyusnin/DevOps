pipeline {
    agent any

    stages {
        stage('Deploy') {
            steps {
                ansiblePlaybook(
                    playbook: './ansible/firstPlaybook.yml',
                    inventory: './ansible/inventory/stend1/hosts',
                    hostKeyChecking: false,
                    disableHostKeyChecking: true,
                    credentialsId: '~/.ssh/id_rsa',
                    tags: 'deploy',
                )
            }
        }

        stage('Start') {
            steps {
                ansiblePlaybook(
                    playbook: './ansible/firstPlaybook.yml',
                    inventory: './ansible/inventory/stend1/hosts',
                    hostKeyChecking: false,
                    disableHostKeyChecking: true,
                    credentialsId: '~/.ssh/id_rsa',
                    tags: 'start'
                )
            }
        }
    }
}
