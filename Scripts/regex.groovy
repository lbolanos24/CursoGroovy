// Java sample Pattern

import java.util.regex.*;
Pattern pattern =Pattern.compile("a\\\\b") // en kjava para usar el back slash se necesita colocar 4 de ellos
println pattern        // a con un solo \ ya con 4\ sale a\\b
println pattern.class  // class java.util.regex.Pattern

//Patterns in Groovy

String slashy = /a\b/  // colocar informacion detre slash permite el uso de back slash simple
String url = $/http://threal/danvega.com/blog/$   // cuando hay varios se usa el dollar slash inicio y fin
println slashy.class

def pattern2 =  ~/a\b/   //class java.lang.String
println pattern2.class // class java.util.regex.Pattern

// Find | Match
//Find
def text = "empieza con Pablito clavo un clavito, que clavito clavo pablito"
def pattern3 = ~/Pablito clavo/
def finder = text =~ pattern3
def matcher = text ==~ pattern3

println finder  // java.util.regex.Matcher[pattern=Pablito clavo region=0,63 lastmatch=]
println finder.size()  //1
println matcher  // boolean: false

def text2 = "Pablito clavo"
def pattern4 = ~/Pablito clavo/
def matcher2 = text2 ==~ pattern4
println matcher2  // boolean: true


def text3 = "empieza con Pablito clavo un clavito, que clavito clavo pablito"
def pattern5 = ~/Pablito/

text3 = text3.replaceFirst (pattern5,"Dolores")
println text3 // empieza con Dolores clavo un clavito, que clavito clavo pablito

