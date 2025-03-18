import groovyx.net.http.ContentType
import groovyx.net.http.RESTClient

@Grab('org.codehaus.groovy.modules.http-builder:http-builder:0.7.1')
@Grab(group='org.apache.ivy', module='ivy', version='2.5.2')

String base = 'https://api.chucknorris.io/'

def chuck = new RESTClient(base)
def params = [fistName : "Liliam", lastName: "Bolanos"]


chuck.contentType = ContentType.JSON

chuck.get(path:'/jokes/random', query: params){ response, json ->
    println response.status
    println json
}

