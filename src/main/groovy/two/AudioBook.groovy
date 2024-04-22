package two

import groovy.transform.Immutable
import common.Book

@Immutable(allProperties = true)
class AudioBook implements Book, CanEqual {
    int lengthInMinutes

    boolean canEqual(other) {
        other in Book
    }

    boolean equals(other) {
        other in PrintedBook ? other == this : _equals(other)
    }
}
