import groovy.transform.TypeChecked
import two.AudioBook
import two.PrintedBook

@TypeChecked(extensions = 'canEquals.groovy')
def method() {
    var pBook = new PrintedBook(328, "1984", "George Orwell", 1961)
    var aBook = new AudioBook(682, "1984", "George Orwell", 2006)
//    println pBook == aBook
    assert pBook.equals(aBook)
    assert aBook.equals(pBook)
//    println aBook == pBook
//    println aBook != pBook
//    assert 3.equals('foo') //[Static type checking] - Invalid equality check: int != java.lang.String
}

method()
