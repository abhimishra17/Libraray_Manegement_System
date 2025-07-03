public class Book {
     String title;
     String author;
    String genre;

    public Book(String title, String author, String genre) {
        this.title  = title;
        this.author = author;
        this.genre  = genre;
    }

    public String getTitle()  { return title;  }
    public String getAuthor() { return author; }
    public String getGenre()  { return genre;  }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book other = (Book) o;
        return title.equalsIgnoreCase(other.title) &&
                author.equalsIgnoreCase(other.author);
    }

    @Override
    public int hashCode() {
        return (title.toLowerCase() + "|" + author.toLowerCase()).hashCode();
    }

    @Override
    public String toString() {
        return "\"" + title + "\" by " + author + " | Genre: " + genre;
    }
}


