pipelineJob('Golang pipeline') {
    definition {
        cpsScm {
            scm {
                git('https://github.com/nightdesoul/golang_example.git')
            }
        }
    }
}