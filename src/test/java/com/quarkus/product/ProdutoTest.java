package com.quarkus.product;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.github.database.rider.cdi.api.DBRider;
import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.dataset.DataSet;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
 

@QuarkusTest
@DBRider
@DBUnit(caseSensitiveTableNames = true)
@QuarkusTestResource(DatabaseLifecycle.class)
public class ProdutoTest {

	
	@Test
	@DataSet(value = "produtos1.yml")
	public void test1() {
		 Assert.assertEquals(1, Produto.count());
	}
}
