pipeline {
    agent any

    stages {
        stage('Deploy') {
            steps {
                ansiblePlaybook(
                    playbook: './ansible/firstPlaybook.yml',
                    inventory: './ansible/inventory/stend1/hosts',
                    tags: 'deploy'
                )
            }
        }

        stage('Start') {
            steps {
                ansiblePlaybook(
                    playbook: './ansible/firstPlaybook.yml',
                    inventory: './ansible/inventory/stend1/hosts',
                    tags: 'start'
                )
            }
        }
    }
}
