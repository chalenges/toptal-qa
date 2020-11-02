all: build compress build-docker-image

build:
	mkdir ../imburse-qa
	cp -r ../src ../imburse-qa/
	cp ../config.json ../imburse-qa/
	cp ../pom.xml ../imburse-qa/
	cp -r ../build ../imburse-qa/

compress:
	tar -zcvf imburse-qa.tar.gz ../imburse-qa
	rm -r ../imburse-qa/

build-docker-image:
	docker build -t imburse-qa:0.1.0 .
