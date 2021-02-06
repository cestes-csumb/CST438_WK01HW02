/*
Title: IntentFactory.java
Purpose: Interface for our intent factory.
 */
package com.example.wk01hw02;

import android.content.Intent;

public interface IntentFactory {
    Intent intent = new Intent();
    public Intent GenerateIntent();
}
