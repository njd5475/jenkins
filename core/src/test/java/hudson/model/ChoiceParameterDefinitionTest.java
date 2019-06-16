package hudson.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import hudson.util.FormValidation;

public class ChoiceParameterDefinitionTest {
    @Test
    public void shouldValidateChoices(){
        assertFalse(ChoiceParameterDefinition.areValidChoices(""));
        assertFalse(ChoiceParameterDefinition.areValidChoices("        "));
        assertTrue(ChoiceParameterDefinition.areValidChoices("abc"));
        assertTrue(ChoiceParameterDefinition.areValidChoices("abc\ndef"));
        assertTrue(ChoiceParameterDefinition.areValidChoices("abc\r\ndef"));
    }

    @Test
    public void testCheckChoices() throws Exception {
        ChoiceParameterDefinition.DescriptorImpl descriptorImpl = new ChoiceParameterDefinition.DescriptorImpl();

        assertEquals(FormValidation.Kind.OK, descriptorImpl.doCheckChoices("abc\ndef").kind);
        assertEquals(FormValidation.Kind.ERROR, descriptorImpl.doCheckChoices("").kind);
    }
}
