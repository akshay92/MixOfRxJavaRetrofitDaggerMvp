package mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.ui.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.R;
import mvp.retrofit.dagger.rxjava.android.com.mixofrxjavadaggerretrofitmvp.data.model.Product;

/**
 * Created by akshay trivedi on 24/06/18.
 */
public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>  {

   private List<Product> productList;
   public ProductListAdapter(List<Product> productList){
       this.productList=productList;
   }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.txLandMark.setText(product.getLandmark());
        holder.txPrice.setText(product.getPrice()+"");
        holder.txName.setText(product.getName());
        holder.txCity.setText(product.getCity());
        holder.txRating.setText(product.getReviewCount()+"");
        holder.txReview.setText(product.getRatedText());

    }


    @Override
    public int getItemCount() {
        return productList.size();
    }

    public  class ProductViewHolder extends RecyclerView.ViewHolder{

        private TextView txName,txPrice,txRating,txCity, txLandMark,txReview;
        public ProductViewHolder(View itemView) {
            super(itemView);
            txName=(TextView)itemView.findViewById(R.id.txName);
            txPrice=(TextView)itemView.findViewById(R.id.txPrice);
            txRating=(TextView)itemView.findViewById(R.id.txRating);
            txReview=(TextView)itemView.findViewById(R.id.txReview);
            txCity=(TextView)itemView.findViewById(R.id.txCity);
            txLandMark=(TextView)itemView.findViewById(R.id.txLandmark);

        }
    }

}
