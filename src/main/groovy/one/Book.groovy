package one

trait Book {
    String title
    String author
    int year

    boolean canEqual(Object other) {
        other in Book
    }

    boolean equals(Object other) {
        if (other in Book) {
            return other.canEqual(this)
                && other.title == title
                && other.author == author
        }
        false
    }
}
