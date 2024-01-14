# ITF Chartizate

---

[![Twitter URL](https://img.shields.io/twitter/url?logoColor=blue&style=social&url=https%3A%2F%2Fimg.shields.io%2Ftwitter%2Furl%3Fstyle%3Dsocial)](https://twitter.com/intent/tweet?text=%20Checkout%20this%20%40github%20repo%20by%20%40joaofse%20%F0%9F%91%A8%F0%9F%8F%BD%E2%80%8D%F0%9F%92%BB%3A%20https%3A//github.com/JEsperancinhaOrg/itf-chartizate)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=ITF%20Chartizate&color=informational)](https://github.com/JEsperancinhaOrg/itf-chartizate)
[![Maven Central](https://img.shields.io/maven-central/v/org.jesperancinha.itf/itf-chartizate)](https://search.maven.org/search?q=itf.itf-chartizate)
[![GitHub release](https://img.shields.io/github/release-pre/JEsperancinhaOrg/itf-chartizate.svg)](https://github.com/JEsperancinhaOrg/itf-chartizate/releases)
[![GitHub release (latest SemVer)](https://img.shields.io/github/v/release/JEsperancinhaOrg/itf-chartizate)](https://github.com/JEsperancinhaOrg/itf-chartizate/releases)
[![javadoc](https://javadoc.io/badge2/org.jesperancinha.itf/itf-chartizate/javadoc.svg)](https://javadoc.io/doc/org.jesperancinha.itf/itf-chartizate)
[![GitHub License](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](https://www.apache.org/licenses/LICENSE-2.0)

[![CircleCI](https://circleci.com/gh/JEsperancinhaOrg/itf-chartizate.svg?style=svg)](https://circleci.com/gh/JEsperancinhaOrg/itf-chartizate)
[![itf-chartizate](https://github.com/JEsperancinhaOrg/itf-chartizate/actions/workflows/itf-chartizate.yml/badge.svg)](https://github.com/JEsperancinhaOrg/itf-chartizate/actions/workflows/itf-chartizate.yml)

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/5f7026624ff244eca9ba1e2dc9c99364)](https://www.codacy.com/gh/JEsperancinhaOrg/itf-chartizate/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=JEsperancinhaOrg/itf-chartizate&amp;utm_campaign=Badge_Grade)
[![codebeat badge](https://codebeat.co/badges/960ed15e-a5c4-42f2-8078-c691a5d1833b)](https://codebeat.co/projects/github-com-jesperancinhaorg-itf-chartizate-master)
[![BCH compliance](https://bettercodehub.com/edge/badge/JEsperancinhaOrg/itf-chartizate?branch=master)](https://bettercodehub.com/)

[![Codacy Badge](https://app.codacy.com/project/badge/Coverage/5f7026624ff244eca9ba1e2dc9c99364)](https://www.codacy.com/gh/JEsperancinhaOrg/itf-chartizate/dashboard?utm_source=github.com&utm_medium=referral&utm_content=JEsperancinhaOrg/itf-chartizate&utm_campaign=Badge_Coverage)
[![Coverage Status](https://coveralls.io/repos/github/JEsperancinhaOrg/itf-chartizate/badge.svg?branch=master)](https://coveralls.io/github/JEsperancinhaOrg/itf-chartizate?branch=master)
[![codecov](https://codecov.io/gh/jesperancinhaorg/itf-chartizate/branch/master/graph/badge.svg?token=851RSEZJTX)](https://codecov.io/gh/jesperancinhaorg/itf-chartizate)

[![GitHub language count](https://img.shields.io/github/languages/count/JEsperancinhaOrg/itf-chartizate.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/top/JEsperancinhaOrg/itf-chartizate.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/code-size/JEsperancinhaOrg/itf-chartizate.svg)](#)

---

## Technologies used

Please check the [TechStack.md](TechStack.md) file for details.

## Description

This is an image to char coder, with a spin off to the current available ones
ITF comes from image train filters and the idea is to use this library in many other projects. However the idea was to create a train of filters where each wagon would transform the image. It should work much like the chain of responsibility pattern.

Example:

[![alt text](documentation/testMarket.jpg "Bologna Market Original Image")](https://goo.gl/maps/ujJC9RPnpqA3QG3R9)
[![alt text](documentation/testMarket1.png "Bologna Market Filter Image")](https://goo.gl/maps/ujJC9RPnpqA3QG3R9)
[![alt text](documentation/testMarket2.png "Bologna Market Filter Rd Image")](https://goo.gl/maps/ujJC9RPnpqA3QG3R9)

There are more available libraries to use in different environments. Please take a look at the [itf-chartizate-modules](https://github.com/JEsperancinhaOrg/itf-chartizate-modules) project.

## Tools

$ git push --delete origin 2.0.0  
$ git tag --delete 2.0.0

```text
gpg --keyserver hkp://keyserver.ubuntu.com --send-keys <your GPG key>
gpg --list-keys
export GPG_TTY=$(tty)
mvn clean deploy -Prelease
mvn nexus-staging:release  -Prelease
```

## Maven

```xml
<dependency>
  <groupId>org.jesperancinha.itf</groupId>
  <artifactId>itf-chartizate</artifactId>
  <version>5.0.1-SNAPSHOT</version>
  <type>pom</type>
</dependency>
```

---

## References

-   [Definitive Guide To Java 12](https://blog.codefx.org/java/java-12-guide/)
-   [Publish AAR to jCenter and Maven Central](https://gist.github.com/lopspower/6f62fe1492726d848d6d)
-   [Publishing Android Library to Bintray with Gradle + Buddy.Works](https://medium.com/camerakit/publishing-android-library-to-bintray-with-gradle-buddy-works-dd50cbd03df5)
-   [How to distribute your own Android library through jCenter and Maven Central from Android Studio](https://inthecheesefactory.com/blog/how-to-upload-library-to-jcenter-maven-central-as-dependency/en)
-   [Creating .asc signature files with GPG](http://www.benmccann.com/creating-asc-signature-files-with-gpg/)
-   [Publish java library to JFrog Bintray and OSS Sonatype with Gradle](https://medium.com/@rosolko/publish-java-library-to-jfrog-bintray-and-sonatype-with-gradle-1a3ebd5b8be8)
-   [Enjoy Bintray and use it as pain-free gateway to Maven Central](https://blog.bintray.com/2014/02/11/bintray-as-pain-free-gateway-to-maven-central/)
-   [Android Library Publishing Maven Artifacts via gradle](https://gist.github.com/danielesegato/3ea6f99c968ce0b795c5390844ad4ff7)
-   [Gradle generate javadoc for Android](https://gist.github.com/kibotu/994c9cc65fe623b76b76fedfac74b34b)
-   [A Complete Guide to Create and Publish an Android Library to Maven Central](https://medium.com/@zubairehman.work/a-complete-guide-to-create-and-publish-an-android-library-to-maven-central-6eef186a42f5)
-   [Publish a Java Project to Maven Central with Gradle](http://weibeld.net/java/publish-to-maven-central.html)
-   [Sign and publish on Maven Central a Project with the new maven-publish Gradle plugin](https://medium.com/@nmauti/sign-and-publish-on-maven-central-a-project-with-the-new-maven-publish-gradle-plugin-22a72a4bfd4b)
-   [How to Upload an Open-Source Java Library to Maven Central](https://www.freecodecamp.org/news/how-to-upload-an-open-source-java-library-to-maven-central-cac7ce2f57c/)
-   [Nexus Sonatype](https://oss.sonatype.org/#welcome)
-   [Working with PGP Signatures](https://central.sonatype.org/pages/working-with-pgp-signatures.html)

---

## About me

[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=Jesperancinha&style=for-the-badge&logo=github&color=grey "GitHub")](https://github.com/jesperancinha)
