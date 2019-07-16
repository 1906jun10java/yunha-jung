// Book Class: Represents a Book
class Book {
    constructor(title, author, genre, coverimage) {
      this.title = title;
      this.author = author;
      this.genre = genre;
      this.coverimage = coverimage;
    }
  }
  
  // UI Class: Handle UI Tasks
  class UI {
    static displayBooks() {
      const books = Store.getBooks();
  
      books.forEach((book) => UI.addBookToList(book));
    }
    static addBookToList(book) {
      const list = document.querySelector('#book-list');
  
      const row = document.createElement('tr');
  
      row.innerHTML = `
        <td>${book.title}</td>
        <td>${book.author}</td>
        <td>${book.genre}</td>
        <td>${book.coverimage}</td>
      `;
      //Appends a node as the last child of a node.
      list.appendChild(row);
    }
    static clearFields() {
      document.querySelector('#title').value = '';
      document.querySelector('#author').value = '';
      document.querySelector('#genre').value = '';
      document.querySelector('#coverimage').value = '';
    }
  }
  
  // Store Class: Handles Storage
  class Store {
    static getBooks() {
      let books;
      //Change from localStorage to sessionStorage.
      if(sessionStorage.getItem('books') === null) {
        books = [];
      } else {
        //The data becomes a JavaScript object.
        //Change from localStorage to sessionStorage.
        books = JSON.parse(sessionStorage.getItem('books'));
      }
  
      return books;
    }
    static addBook(book) {
      const books = Store.getBooks();
      books.push(book);
       //Convert a JavaScript object into a string.
       //Change from localStorage to sessionStorage.
       sessionStorage.setItem('books', JSON.stringify(books));
    }
  }
  
  // Event: Display Books
  document.addEventListener('DOMContentLoaded', UI.displayBooks);

  // Event: Add a Book
  document.querySelector('#book-form').addEventListener('submit', (e) => {
    // Prevent actual submit
    e.preventDefault();
  
    // Get form values
    const title = document.querySelector('#title').value;
    const author = document.querySelector('#author').value;
    const genre = document.querySelector('#genre').value;
    const coverimage = document.querySelector('#coverimage').value;
  
   
      // Instatiate book
      const book = new Book(title, author, genre, coverimage);
      // Add Book to UI
      UI.addBookToList(book);
      // Add book to store
      Store.addBook(book);
      // Clear fields
      UI.clearFields();
    }
  );
      var loadFile = function(event) {
      var output = document.getElementById('output');
      output.src = URL.createObjectURL(event.target.files[0]);
    };
