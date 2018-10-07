package bookmanager.groupone.test2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddBook extends AppCompatActivity {
    EditText titleInput;
    EditText authorInput;
    EditText courseInput;
    EditText isbnInput;
    EditText priceInput;

    Button saveButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        titleInput = (EditText) findViewById(R.id.titleInput);
        authorInput = (EditText) findViewById(R.id.authorInput);
        courseInput = (EditText) findViewById(R.id.courseInput);
        isbnInput = (EditText) findViewById(R.id.courseInput);
        priceInput = (EditText) findViewById(R.id.priceInput) ;

        saveButton = (Button) findViewById(R.id.saveButton);

    }

    public void addNewBook(View view) {

        String author = authorInput.getText().toString();
        String title = titleInput.getText().toString();
        String price = priceInput.getText().toString();
        String isbn = isbnInput.getText().toString();
        String course = courseInput.getText().toString();

        if( title != null && title.trim() != "" ) {

            if(author == null){
                author = "";
            }
            if(isbn == null){
                author = "";
            }
            if(course == null){
                author = "";
            }

            Book book = SimpleBookManager.getInstance().library.createNonEmptyBook(
                    author, title, tryParseInt(price), isbn, course);

            SimpleBookManager.getInstance().saveChanges();

            //super.onBackPressed();
        }
        else
            {
                /*
            new AlertDialog.Builder(this)
                    .setTitle("No Title")
                    .setMessage("You can't add a book without a title")
                    .setCancelable(false)
                    .show();
                    */
        }
    }

    int tryParseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch(Exception e) {
            return 0;
        }
    }
}
