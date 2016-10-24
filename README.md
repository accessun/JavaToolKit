# Java Tool Kit

This repository is a growing collection of code which provides functionalities that are commonly involved in Java web development. The original intention to establish this collection is to avoid the circumstances where I need to re-invent the wheel repeatedly. So whenever a similar functionality is required during web development process, I can simply turn to this collection to check if there is a piece of code that can be reused, if not, a new piece of code is put into this collection for future reference. This way, the user of this collection can increase efficiency of Java web development.

Note that this repository is by no means a complete and thoroughly-tested library. The sole purpose is to provide a rudimentary tool kit that user can look for code to be a good starting point.

# Documentation

> Packages are listed here in alphabetical order

#### `io.github.accessun.encryption`

`BCryptEncryption` encrypts and check encrypted password using [bcrypt encryption algorithm](https://en.wikipedia.org/wiki/Bcrypt). This algorithm is recommended over md5 algorithm.

#### `io.github.accessun.image`

`ImageBase64Encoding` generates Base64 string representation of an image file.

`VerificationCodeGenerator` generates images of random verification code.

#### `io.github.accessun.io`

`FileOperation` provides two methods: 1. reads in text file and return the content of the file as a string; 2. copies file.

#### `io.github.accessun.markdown`

`MarkdownProcessor` provides methods that: 1. reads in a markdown file and returns the string of its html representation; 2. convert a markdown file to an html file.

#### `io.github.accessun.web`

`SendGetAndPostRequest` contains methods that send `GET` and `POST` request to a server.

`SpringMail` provides methods that send simple text email or email in form of html to a email server.

#### `io.github.accessun.xml`

`XmlProcessing` provides an example to generate an XML as a string. 

