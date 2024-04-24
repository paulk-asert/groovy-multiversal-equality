package one

import groovy.transform.Immutable

@Immutable(allProperties = true)
class PrintedBook implements Book {
    int pages

    boolean equals(other) {
        switch (other) {
            case PrintedBook -> this._equals(other)
            case AudioBook -> Book.super.equals(other)
            default -> false
        }
    }
}
