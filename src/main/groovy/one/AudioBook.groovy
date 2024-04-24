package one

import groovy.transform.Immutable

@Immutable(allProperties = true)
class AudioBook implements Book {
    int lengthInMinutes
}
