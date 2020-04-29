package com.cheer.testingdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestShape {

    @Mock
    private Shape shape;

    private static Logger LOGGER = LoggerFactory.getLogger(TestShape.class);
    private Square square;
    private Rectangle rectangle;

    @BeforeAll
    static void beforeClass() {
        LOGGER.info("Before class");
    }

    @BeforeEach
    void setUp() throws Exception {
        LOGGER.info("Before each method");
        square = Mockito.mock(Square.class);
        Mockito.when(square.area()).thenReturn(16);
        Mockito.when(square.convertTo(Rectangle.class)).thenThrow(new RuntimeException());

        rectangle = Mockito.mock(Rectangle.class);
        Mockito.when(rectangle.area()).thenReturn(15);
        Mockito.when(rectangle.convertTo(Rectangle.class)).thenThrow(new Exception("invalid type"));

        Mockito.when(shape.area()).thenReturn(10);
    }

    @Test
    void testEqualSize() {
        LOGGER.info("Testing equal size");
        Assertions.assertEquals(15, rectangle.area());
        Assertions.assertThrows(RuntimeException.class, () -> square.convertTo(Rectangle.class));
        Assertions.assertThrows(Exception.class, () -> rectangle.convertTo(Rectangle.class));
        Assertions.assertEquals(10, this.shape.area());
    }
}
