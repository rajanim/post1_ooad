package org.sfsu.post.manager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by adisonlee 02/07/2017
 *
 * Init by Store
 *
 * ProductReader obtains a product list from text file (for now) used by Store
 * to create a product catalog
 *
 **/
public class ProductReader
{
    private BufferedReader buffReader;
    private String thisLine;

    // default constructor
    ProductReader()
    {
        try
        {
            buffReader = new BufferedReader(new FileReader("src/Products.txt"));
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    // checks if next line is a product or null
    public boolean hasMoreProducts()
    {
        try
        {
            thisLine = buffReader.readLine();
            return thisLine != null;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     *  Splits line into three parts: UPC, Description, and Price
     *  Allows ProductSpec class to get individual product specifications
     *
     *  E.g., itemLineInText[0] = UPC
     *        itemLineInText[1] = Description
     *        itemLineInText[2] = Price
     *
     */
    public ProductSpec getNextProduct()
    {
        String[] itemLineInText = thisLine.split("\\s+");
        return new ProductSpec(itemLineInText[0], itemLineInText[1], Double.parseDouble(itemLineInText[2]));
    }
}

