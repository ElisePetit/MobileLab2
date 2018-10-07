package bookmanager.groupone.test2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BookView extends AppCompatActivity {
public int position;
EditText title;
EditText author;
EditText ISBN;
EditText price;
EditText course;
    TextView info;

public Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_view);
        position = getIntent().getIntExtra("pos", 0);
        book = SimpleBookManager.getInstance().library.getBook(position);
        Log.d("TAG", book.getTitle());
        Log.d("TAG", book.getAuthor());
        title = (EditText) findViewById(R.id.input_title);
        author = (EditText) findViewById(R.id.input_author);
        ISBN = (EditText) findViewById(R.id.input_isbn);
        price = (EditText) findViewById(R.id.input_price);
        course = (EditText) findViewById(R.id.input_course);
        info = (TextView) findViewById(R.id.info_text) ;

        title.setText(book.getTitle());
        author.setText(book.getAuthor());
        ISBN.setText(book.getIsbn());
        price.setText(Integer.toString(book.getPrice()));
        course.setText(book.getCourse());
    }

    public void editBook(View view) {
        book.setTitle(title.getText().toString());
        book.setAuthor(author.getText().toString());
        book.setCourse(course.getText().toString());
        book.setIsbn(ISBN.getText().toString());
        try {
            book.setPrice(Integer.parseInt(price.getText().toString()));
        }
        catch ( NumberFormatException e )
        {
            book.setPrice(0);
        }
        SimpleBookManager.getInstance().library.saveChanges();

        info.setVisibility(View.VISIBLE);
    }

    public void deleteBook(View view) {
        SimpleBookManager.getInstance().library.removeBook(book);
        SimpleBookManager.getInstance().library.saveChanges();
        info.setVisibility(View.VISIBLE);
    }

}
