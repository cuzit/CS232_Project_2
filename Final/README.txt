Ascii Image Converter Version 1.0
By: Matt Silvey, Tyler Hughes, Crystal 
Williams, Jackie Blue, and Aaron Rudolph
CS232 Dr. Garrett Project 2

Contents:
1. Parts
2. Instructions
3. Staff

1. Parts

There are four classes that are used by the main. These are AsciiImage,
AsciiViewer, Image and ImageViewer. The main is called Project2.

AsciiImage - Stores a square array of values representing an image in
             Ascii form.
AsciiViewer - Displays a zoomable AsciiImage in a GUI.
Image - Stores a square array of values representing pixel shade intensity
        of a black-and-white image.
ImageViewer - Displays a zoomable, black-and-white image in a GUI.

The main file, Project2, contains the functionality of the program.

Included in the zip is an jpeg file, test.jpg. It, by default, is used to
execute the program. It can be freely modified with no repercussions. Also
included is this readme.

2. Instructions

To use the code for the first time, follow these instructions:

1. Open a terminal or "cmd.exe"
2. cd to the unzipped directory
3. When inside the directory with the .java files, execute the command
   "javac *.java" (without quotes) to compile all of the code.
4. Use the command "java Project2 /path/to/image" (without quotes) to
   execute the program.
   E.G. "java Project2 test.jpg" (without quotes) will execute the program
   using the image test.jpg, assuming test.jpg is in the same directory.
   "java Project2 /home/[username]/Pictures/Path/to/picture.jpg" will
   execute the program using the image picture.jpg, assuming this file
   exists on this path.

Afterwards, only step four needs to be followed to execute again.

3. Staff

Matt Silvey - Group leader, AsciiImage.java, parts of the Main
Tyler Hughes - AsciiViewer.java, most of the Main
Crystal Williams - ImageViewer.java, part of the Main
Aaron Rudolph - AsciiViewer.java
Jackie Blue - Image.java
