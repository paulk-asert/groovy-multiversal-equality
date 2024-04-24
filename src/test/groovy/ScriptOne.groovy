import groovy.transform.TypeChecked
import one.AudioBook
import one.PrintedBook

@TypeChecked(extensions = 'strictEqualsButRelaxedForPrintedBook.groovy')
def method() {
    var pBook = new PrintedBook(328, "1984", "George Orwell", 1949)
    var aBook = new AudioBook(682, "1984", "George Orwell", 2006)
    assert pBook == aBook
    var reprint = new PrintedBook(328, "1984", "George Orwell", 1961)
    assert pBook != reprint
//    assert aBook != pBook // [Static type checking] - Invalid equality check: AudioBook != PrintedBook
//    assert 3 != 'foo' // [Static type checking] - Invalid equality check: int != java.lang.String
//    assert 3 == 3f // [Static type checking] - Invalid equality check: int != float
}

method()
