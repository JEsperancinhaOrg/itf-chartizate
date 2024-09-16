SHELL := /bin/sh

b: build
build: build-maven
build-maven:
	mvn clean install
coverage:
	mvn clean jacoco:prepare-agent install jacoco:report
report:
	mvn omni-coveragereporter:report
deps-plugins-update:
	curl -sL https://raw.githubusercontent.com/jesperancinha/project-signer/master/pluginUpdatesOne.sh | bash -s -- $(PARAMS)
deps-java-update:
	curl -sL https://raw.githubusercontent.com/jesperancinha/project-signer/master/javaUpdatesOne.sh | bash
deps-node-update:
	curl -sL https://raw.githubusercontent.com/jesperancinha/project-signer/master/nodeUpdatesOne.sh | bash
deps-quick-update: deps-plugins-update deps-java-update deps-node-update
