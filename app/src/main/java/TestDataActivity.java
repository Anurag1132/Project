import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shoponline.Models.Category;
import com.example.shoponline.Models.Products;
import com.example.shoponline.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class TestDataActivity extends AppCompatActivity implements View.OnClickListener {

    Button addTestDatabtn;
    FirebaseFirestore database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_data);
        addTestDatabtn=findViewById(R.id.addTestData);
        addTestDatabtn.setOnClickListener(this);
        database=FirebaseFirestore.getInstance();
    }

    @Override
    public void onClick(View v) {

        //testdata to add products
       // addProduct("PI0020","Vans","Short","$12.00","Shorts","MEN",20);


    }

    public void addCategory(String name){
        Category new_cat=new Category(name);
        database.collection("category")
                .add(new_cat)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getApplicationContext(),"Category Submitted",Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),"Error. Try Again"+e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
    }

    public void addProduct(String product_id,String brand,String product,String price,String product_cat,String gender,int imgid){
        Products new_cat=new Products( product_id, brand, product, price, product_cat, gender, imgid);
        database.collection("products")
                .add(new_cat)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getApplicationContext(),"product Submitted",Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),"Error. Try Again"+e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
    }
}