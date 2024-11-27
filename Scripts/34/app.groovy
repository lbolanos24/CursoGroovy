@Grapes(
    @Grab( group='org.apache.commons',module='commons-lang3',version='3.14.0')
    //@Grab(group='org.netbeans.external', module='org-apache-commons-lang3', version='RELEASE130')
)

import org.apache.commons.lang3.text.WordUtils

String name = "Liliam Paola Bolanos"
WordUtils wordUtils= new WordUtils()

println wordUtils.initials(name)