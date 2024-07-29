pipeline {
    agent{
        node { label 'docker-label' }
    }
    triggers{
        pollSCM '*/5 * * * *'
    }

    stages{
        stage('BUILD') {
            steps{
                echo "test building"
                sh '''
                    pwd
                    ls -l .
                '''
            }
        }
        
        stage('TEST'){
            steps{
                echo "test TEST"
                sh '''
                    pstree
                '''
            }
        }

        stage('DEPLOY'){
            steps{
                echo "test DEPLOY"
                sh '''
                    env
                '''
            }
        }
    }
}