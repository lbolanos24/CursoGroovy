import groovy.xml.MarkupBuilder

def books =[
        [isbn:"978-1935182443", title:"Groovy in Action 2nd Edition", author:"Dierk Koenig", price:"50.58"],
        [isbn:"978-1935182948", title:"Making Java Groovy", author:"Ken Kousen",price:"33.96"],
        [isbn:"978-1935182443", title:"Groovy in Action 2nd Edition", author:"Dierk Koenig", price:"50.58"]
]

FileWriter fileWriter = new FileWriter("html/books.html")
MarkupBuilder builder = new MarkupBuilder(fileWriter)

builder.books {
    head {
        title"Books"
    }
    body{
        h1("books")
        table{
            tr{
                th 'ISBN'
                th 'Title'
                th 'Author'
                th 'Price'
            }
            books.each { book ->
                tr {
                    td book.isbn
                    td book.title
                    td book.author
                    td book.price
                }
            }
        }
    }
}
