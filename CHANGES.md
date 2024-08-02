## UNDERSTANDING HOW NEW LINE WORKS IN WINDOWS AND LINUX.
```
\n   ---> In Linux
\r\n ---> In Windows
\r   ---> In Mac/Apple
```

## What Happens in server
When we git clone in server(a linux environment).
Based on the OS git uses new line character in case of our
server it is '\n'.

## What Happens in Locally(Windows)
When we git clone in windows it use "\r\n" as the new line
character.

The spring application contain Generating commands to be used
by docker container.
Since docker requires "\n" but running on windows the 
command generated contain "\r\n" leads to 
ERROR :  bash\\n file or directory doesn't exist.

CODE ADDITION:
So a line is added to replace "\r\n" with "\n".


## When running build image in windows from command line
Since (dot).sh i.e shell files are meant to run on linux 
server so it should have "\n" new line.
But clonning in windows uses "\r\n".

We have two solution.

### Using WSL Ubuntu
Use wsl ubuntu to run shell script but before the install
"dos2unix" module(sudo apt insall dos2unix) to convert 
"\r\n" to "\n"  in all shell as well as docker script.

Because those scripts are run progammatically by the spring application.


### Using Intellij
Navigate to the file and open it in intellij.
At the bottom there will be a button to change the 
new line charater on opened file.




