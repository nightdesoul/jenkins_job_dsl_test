def gitUrl = 'https://github.com/nightdesoul/golang_example'

job('Golang Docker example'){
    label("builder")
    scm{
        git(gitUrl)
    }
    triggers{
        scm('H/5 * * * *')
    }
    wrappers{
        golang('golang')
    }
    steps{
        shell("go test")
        dockerBuildAndPublish{
            repositoryName('nightdesoul/jenkins_dsl_test')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
