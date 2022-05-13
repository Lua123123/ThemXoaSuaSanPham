package com.example.themxoasuasanpham.network;

import com.example.themxoasuasanpham.model.addproduct.AddProduct;
import com.example.themxoasuasanpham.model.category.CategorySpinnerProduct;
import com.example.themxoasuasanpham.model.createunit.UnitCreate;
import com.example.themxoasuasanpham.model.itemlistvariant.ItemListVariant;
import com.example.themxoasuasanpham.model.product.Success;
import com.example.themxoasuasanpham.model.spinner.CategorySpinner;
import com.example.themxoasuasanpham.model.unit.UnitSpinner;
import com.example.themxoasuasanpham.model.updateItemVariant.UpdateItemVariant;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface API {
    public static final String DOMAIN = "http://nhom-16.thegoodguys.tech/";
    API api = new Retrofit.Builder()
            .baseUrl(DOMAIN) // API base url
            .addConverterFactory(GsonConverterFactory.create()) // Factory phụ thuộc vào format JSON trả về
            .build()
            .create(API.class);

    @GET("api/item-list?vendor_id=1")
    Call<Success> getItem(@Header("Version") String Version,
                          @Header("Device-Type") String device_type,
                          @Header("Accept-Language") String accept_language,
                          @Header("Accept") String accept,
                          @Header("X-Authorization") String x_authorization,
                          @Header("Authorization") String authorization); //@Body ProductBody productBody

    @FormUrlEncoded
    @POST("api/item?vendor_id=1")
    Call<AddProduct> addProducts(@Header("Version") String Version,
                                 @Header("Device-Type") String device_type,
                                 @Header("Accept-Language") String accept_language,
                                 @Header("Accept") String accept,
                                 @Header("X-Authorization") String x_authorization,
                                 @Header("Authorization") String authorization,

                                 @Field("item_name") String item_name,
                                 @Field("item_description") String item_description,
                                 @Field("category_id") String category_id,
                                 @Field("unit_id") String unit_id,
                                 @Field("brand_name") String brand_name,
                                 @Field("price") String price,
                                 @Field("cost") String cost,
                                 @Field("stock_limit") String stock_limit);


    @GET("api/unit-list?vendor_id=1")
    Call<UnitSpinner> getUnit(@Header("Version") String Version,
                              @Header("Device-Type") String device_type,
                              @Header("Accept-Language") String accept_language,
                              @Header("Accept") String accept,
                              @Header("X-Authorization") String x_authorization,
                              @Header("Authorization") String authorization);


    @GET("api/category-list?vendor_id=1")
    Call<CategorySpinnerProduct> getCategory(@Header("Version") String Version,
                                             @Header("Device-Type") String device_type,
                                             @Header("Accept-Language") String accept_language,
                                             @Header("Accept") String accept,
                                             @Header("X-Authorization") String x_authorization,
                                             @Header("Authorization") String authorization);

    @FormUrlEncoded
    @POST("api/unit?vendor_id=1")
    Call<UnitCreate> createUnit(@Header("Version") String Version,
                                @Header("Device-Type") String device_type,
                                @Header("Accept-Language") String accept_language,
                                @Header("Accept") String accept,
                                @Header("X-Authorization") String x_authorization,
                                @Header("Authorization") String authorization,

                                @Field("unit_name") String unit_name);

    @GET("api/item-variant-list")
    Call<ItemListVariant> getItemVariant(@Header("Version") String Version,
                                         @Header("Device-Type") String device_type,
                                         @Header("Accept-Language") String accept_language,
                                         @Header("Accept") String accept,
                                         @Header("X-Authorization") String x_authorization,
                                         @Header("Authorization") String authorization,

                                         @Query("vendor_id") String vendor_id,
                                         @Query("item_id") String item_id);

    @FormUrlEncoded
    @PUT("api/item-variant")
    Call<UpdateItemVariant> updateItemVariant(@Header("Version") String Version,
                                              @Header("Device-Type") String device_type,
                                              @Header("Accept") String accept,
                                              @Header("X-Authorization") String x_authorization,
                                              @Header("Authorization") String authorization,

                                              @Field("vendor_id") String vendor_id,
                                              @Field("item_id") String item_id,
                                              @Field("item_variant_id") String item_variant_id,

                                              @Field("color") String color,
                                              @Field("size") String size,
                                              @Field("price") String price,
                                              @Field("cost") String cost,
                                              @Field("total_stock") String total_stock,
                                              @Field("stock_limit") String stock_limit,
                                              @Field("image") String image);

    @FormUrlEncoded
    @POST("api/item-variant")
    Call<UpdateItemVariant> createItemVariant(@Header("Version") String Version,
                                        @Header("Device-Type") String device_type,
                                        @Header("Accept") String accept,
                                        @Header("X-Authorization") String x_authorization,
                                        @Header("Authorization") String authorization,

                                        @Field("vendor_id") String vendor_id,
                                       @Field("item_id") String item_id,
                                       @Field("color") String color,
                                       @Field("size") String size,
                                       @Field("price") String price,
                                       @Field("cost") String cost,
                                       @Field("total_stock") String total_stock,
                                       @Field("stock_limit") String stock_limit,
                                       @Field("image") String image);

}
