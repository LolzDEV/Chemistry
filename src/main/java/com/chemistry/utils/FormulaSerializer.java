package com.chemistry.utils;

import com.chemistry.api.ItemElement;
import com.chemistry.elements.Elements;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FormulaSerializer {

    public static ArrayList<ItemStack> deserialize(String s){
        ArrayList<ItemStack> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (Character.isLowerCase(c)){
                if(i+1 <= s.length()-1) {
                    if (Character.isDigit(s.charAt(i + 1))) {
                        for (int x = 0; x < Character.getNumericValue(s.charAt(i + 1)); x++) {
                            result.add(new ItemStack(Elements.getFromSymbol(String.valueOf(s.charAt(i - 1)) + s.charAt(i))));
                        }
                    } else {
                        result.add(new ItemStack(Elements.getFromSymbol(String.valueOf(s.charAt(i - 1)) + s.charAt(i))));
                    }
                }else {
                    result.add(new ItemStack(Elements.getFromSymbol(String.valueOf(s.charAt(i - 1)) + s.charAt(i))));
                }
            }
            if (Character.isUpperCase(c)){
                if(!Character.isLowerCase(s.charAt(i+1))) {
                    if (i + 1 <= s.length()-1) {
                        if (Character.isDigit(s.charAt(i + 1))) {
                            for (int x = 0; x < Character.getNumericValue(s.charAt(i + 1)); x++) {
                                result.add(new ItemStack(Elements.getFromSymbol(String.valueOf(s.charAt(i)))));
                            }
                        } else {
                            result.add(new ItemStack(Elements.getFromSymbol(String.valueOf(s.charAt(i)))));
                        }
                    } else {
                        result.add(new ItemStack(Elements.getFromSymbol(String.valueOf(s.charAt(i)))));
                    }
                }
            }
        }

        return result;

    }


    public static String serialize(ArrayList<ItemStack> stacks){
        StringBuilder formula = new StringBuilder();
        HashMap<String, Integer> cur = new HashMap<>();
        for (ItemStack stack : stacks){
            if(stack.getItem() instanceof ItemElement){
                cur.merge(((ItemElement) stack.getItem()).getSymbol(), stack.getCount(), Integer::sum);
            }
        }
        for(Map.Entry<String, Integer> entry : cur.entrySet()){
            if(entry.getValue() > 1) {
                formula.append(entry.getKey() + entry.getValue());
            } else {
                formula.append(entry.getKey());
            }
        }
        return formula.toString();
    }


}
