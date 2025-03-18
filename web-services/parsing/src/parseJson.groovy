import groovy.json.JsonSlurper

//import groovy.json.JsonSlurper
//
//def books = '''
//{
//    "books": {
//        "currentBook": {
//            "title": "The 4 Hour Work Week",
//            "isbn": "978-0-307-46535-1",
//            "first": [
//                {
//                    "last": "Ferriss",
//                    "twitter": "@tferriss"
//                },
//                "Timothy"
//            ],
//            "author": [
//                {
//                    "last": "Ferriss",
//                    "twitter": "@tferriss"
//                },
//                "Timothy"
//            ],
//            "related": [
//                "The 4 Hour Body",
//                "The 4 Hour chef"
//            ]
//        },
//        "nextBook": {
//            "title": "#AskGaryVee",
//            "isbn": "978-0-06-227312-3",
//            "first": [
//                {
//                    "last": "Vaynerchuck",
//                    "twitter": "@garyvee"
//                },
//                "Gary"
//            ],
//            "author": [
//                {
//                    "last": "Vaynerchuck",
//                    "twitter": "@garyvee"
//                },
//                "Gary"
//            ],
//            "related": [
//                "Jab, Jab, Jab, Right Hook",
//                "Crush it"
//            ]
//        }
//    }
//}
//'''
//
//JsonSlurper sluper = new JsonSlurper()
//def json = sluper.parseText(books)
//
//println( json.books.nextBook.title )

JsonSlurper slurper = new JsonSlurper()
def json = slurper.parse(new File('data/books.json'))

println(json.books.currentBook)
println(json.books.currentBook.title)
println(json.books.currentBook.author)
println(json.books.currentBook.related)