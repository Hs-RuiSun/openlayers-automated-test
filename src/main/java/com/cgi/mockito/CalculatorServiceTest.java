package com.cgi.mockito;

import com.cgi.model.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.mockito.junit.jupiter.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CalculatorServiceTest {
    @InjectMocks
    private CalculatorService calculatorService;
    @Mock
    private CalculatorDao calculatorDao;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testArgumentCaptor() {
        Calculator[] array = {new Calculator(10, "John", false), new Calculator(10, "John", false)};
        List<Calculator> expected = Arrays.asList(array);
        calculatorDao.compare(array);
        ArgumentCaptor<Calculator> captor = ArgumentCaptor.forClass(Calculator.class);

        verify(calculatorDao).compare(captor.capture());
        assertEquals(expected, captor.getAllValues());
    }

    @Test
    public void testMockitoAnswer() {
        Calculator mockCalculator = new Calculator();
        when(calculatorService.save(mockCalculator)).thenAnswer(invocation -> invocation.getArgument(0));
        Calculator calculator = calculatorService.save(mockCalculator);
        assertEquals(mockCalculator, calculator);
    }

    @Test
    public void testReturnDifferentValuesBasedOnParameters() {
        when(calculatorDao.getLabelMessage(anyString())).thenAnswer(
                invocation -> {
                    String args = invocation.getArgument(0);
                    if ("new label".equals(args)) {
                        return "new label:.....";
                    } else if ("old label".equals(args)) {
                        return "old label:.....";
                    }
                    return "invalid arguments";
                });
        assertEquals("new label:.....", calculatorService.getLabelMessage("new label"));
        assertEquals("old label:.....", calculatorService.getLabelMessage("old label"));
    }

    @Test
    public void testOrderValidaQuantity() throws InsufficientProductsException {
        when(calculatorDao.getQuantityInStock()).thenReturn(10);
        Calculator calculator = new Calculator(4, "blue star", false);
        calculatorService.order(calculator);
        verify(calculatorDao, times(1)).getQuantityInStock();
        verify(calculatorDao, times(1)).save(calculator);
    }

    @Test
    public void testFindOne() {
        String name = "isEqualString";
        Integer quantity = 1;
        Calculator calculator = new Calculator();
        //incorrect, if use argument matchers, all arguments have to be provided by matchers
        //when(calculatorDao.findOne(name, any())).thenReturn(calculator);
        //when(calculatorDao.findOne(eq(name), any())).thenReturn(calculator);

        String mockname = "isEqualString";
        Integer mockQuantity = 1;
        when(calculatorDao.findOne(mockname, mockQuantity)).thenReturn(calculator);
        assertEquals(calculator, calculatorService.findOne(name, quantity));
        assertTrue(true, "error message"); //assert the condition is true, if it isn't then return an AssertError with the given message
    }
}
