// ********RoostGPT********
/*
Test generated by RoostGPT for test spring-security-registration using AI Type Open AI and AI Model gpt-4

ROOST_METHOD_HASH=getErrorCodes_906cdf82d8
ROOST_METHOD_SIG_HASH=getErrorCodes_be233aea35

================================VULNERABILITIES================================
Vulnerability: Insecure Deserialization (CWE-502)
Issue: The code uses Jackson library for JSON processing which could potentially lead to insecure deserialization vulnerability if not properly handled.
Solution: Ensure that Jackson's enableDefaultTyping is not used as it can lead to arbitrary code execution. Consider using @JsonTypeInfo annotation for specifying allowed classes for polymorphic deserialization.

Vulnerability: Information Exposure (CWE-200)
Issue: The method getErrorCodes() exposes internal error codes that might leak sensitive information about the system.
Solution: Consider returning a generic error message to the user and log the specific error internally. Alternatively, map the internal error codes to user-friendly messages that do not reveal system details.

================================================================================
""" 
  Scenario 1: Test to check if getErrorCodes returns an array of ErrorCode objects

  Details:  
    TestName: testGetErrorCodesReturnsErrorCodeArray
    Description: This test is meant to check if the getErrorCodes method returns the correct array of ErrorCode objects. 
  Execution:
    Arrange: No arrangement is necessary for this test as the method does not take any parameters.
    Act: Invoke the getErrorCodes method.
    Assert: Use JUnit assertions to check if the returned object is an array of ErrorCode objects.
  Validation: 
    This assertion aims to verify if the getErrorCodes method is returning the correct object type. The expected result is an array of ErrorCode objects because that's what the method is designed to return. This test is significant in ensuring that the method is functioning as expected and returning the correct object type.

  Scenario 2: Test to check if getErrorCodes returns the correct ErrorCode objects

  Details:  
    TestName: testGetErrorCodesReturnsCorrectErrorCodes
    Description: This test is meant to check if the getErrorCodes method returns the correct ErrorCode objects that were previously set. 
  Execution:
    Arrange: Set up an array of ErrorCode objects and assign it to the errorCodes variable.
    Act: Invoke the getErrorCodes method.
    Assert: Use JUnit assertions to check if the returned array of ErrorCode objects matches the array that was set up in the Arrange step.
  Validation: 
    This assertion aims to verify if the getErrorCodes method is returning the correct ErrorCode objects. The expected result is the array of ErrorCode objects that were set up in the Arrange step because that's what was assigned to the errorCodes variable. This test is significant in ensuring that the method is returning the correct data.

  Scenario 3: Test to check if getErrorCodes handles null values correctly

  Details:  
    TestName: testGetErrorCodesHandlesNullValues
    Description: This test is meant to check if the getErrorCodes method handles null values correctly, i.e., it should return null when the errorCodes variable is null. 
  Execution:
    Arrange: Set the errorCodes variable to null.
    Act: Invoke the getErrorCodes method.
    Assert: Use JUnit assertions to check if the returned value is null.
  Validation: 
    This assertion aims to verify if the getErrorCodes method is handling null values correctly. The expected result is null because the errorCodes variable was set to null. This test is significant in ensuring that the method handles null values correctly and does not throw a NullPointerException.
"""
*/

// ********RoostGPT********
package com.baeldung.captcha;

import org.junit.Test;
import org.junit.Assert;
import com.baeldung.captcha.ErrorCode; // import ErrorCode class

public class GoogleResponseGetErrorCodesTest {

    @Test
    public void testGetErrorCodesReturnsErrorCodeArray() {
        GoogleResponse googleResponse = new GoogleResponse();
        googleResponse.setErrorCodes(new ErrorCode[]{ErrorCode.InvalidResponse, ErrorCode.MissingResponse});

        Assert.assertTrue(googleResponse.getErrorCodes() instanceof ErrorCode[]);
    }

    @Test
    public void testGetErrorCodesReturnsCorrectErrorCodes() {
        GoogleResponse googleResponse = new GoogleResponse();
        ErrorCode[] expectedErrorCodes = new ErrorCode[]{ErrorCode.InvalidResponse, ErrorCode.MissingResponse};
        googleResponse.setErrorCodes(expectedErrorCodes);

        Assert.assertArrayEquals(expectedErrorCodes, googleResponse.getErrorCodes());
    }

    @Test
    public void testGetErrorCodesHandlesNullValues() {
        GoogleResponse googleResponse = new GoogleResponse();
        googleResponse.setErrorCodes(null);

        Assert.assertNull(googleResponse.getErrorCodes());
    }
}
