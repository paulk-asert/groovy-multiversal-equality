package two

import groovy.transform.Immutable
import common.Book

@Immutable(allProperties = true)
class PrintedBook implements Book, CanEqual {
    int pages

    boolean canEqual(other) {
        other in PrintedBook || other in AudioBook
    }

    boolean equals(other) {
        switch (other) {
            case PrintedBook -> this._equals(other)
            case AudioBook -> this.author == other.author &&
                this.title == other.title
            default -> false
        }
    }
}
