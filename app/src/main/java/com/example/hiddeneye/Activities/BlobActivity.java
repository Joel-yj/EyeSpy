package com.example.hiddeneye.Activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.hiddeneye.R;
import com.example.hiddeneye.databinding.ActivityBlobBinding;

import java.io.PrintWriter;
import java.io.StringWriter;

public class BlobActivity extends AppCompatActivity {

    ActivityBlobBinding binding;

    public static final String storageConnectionString =
            "DefaultEndpointsProtocol=https;" +
                    "AccountName=testjoel1;" +
                    "AccountKey=dgJefDxywGAy/88I7I2HCOAl4e9Z9dDfjUOtHmtUM8mhUhsosIU5Esbtwt57K245xSOLcbOKIo02+AStzKGhAg==";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blob);
        replaceFragment(new PlaceholderFragment());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.blob_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Runs the blob getting started sample.
     */
    public void runBlobGettingStartedSample(View view) {
        new BlobGettingStartedTask(this, (TextView) findViewById(R.id.textView))
                .execute();

    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_blob, container,
                    false);
            return rootView;
        }
    }

    /**
     * Prints the specified text value to the view and to LogCat.
     *
     * @param view
     *            The view to print to.
     * @param value
     *            The value to print.
     */
    public void outputText(final TextView view, final String value) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                view.append(value + "\n");
                System.out.println(view);
            }
        });
    }

    /**
     * Clears the text from the specified view.
     *
     * @param view
     *            The view to clear.
     */
    public void clearText(final TextView view) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                view.setText("");
            }
        });
    }

    /**
     * Prints out the exception information .
     */
    public void printException(Throwable t) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        t.printStackTrace(printWriter);
        outputText(
                (TextView) findViewById(R.id.textView),
                String.format(
                        "Got an exception from running samples. Exception details:\n%s\n",
                        stringWriter.toString()));
    }

    /**
     * Prints out the sample start information .
     */
    public void printSampleStartInfo(String sampleName) {
        TextView view = (TextView) findViewById(R.id.textView);
        clearText(view);
        outputText(view, String.format(
                "The Azure storage client library sample %s is starting...",
                sampleName));
    }

    /**
     * Prints out the sample complete information .
     */
    public void printSampleCompleteInfo(String sampleName) {
        outputText((TextView) findViewById(R.id.textView), String.format(
                "The Azure storage client library sample %s completed.\n",
                sampleName));
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container,fragment);
        fragmentTransaction.commit();
    }



}