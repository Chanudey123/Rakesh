package com.example.Rakesh;

import com.example.Rakesh.Payload.OrdDto;
import com.example.Rakesh.Repository.OrdRepository;
import com.example.Rakesh.Service.OrdService;
import com.example.Rakesh.entity.Ord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
class RakeshApplicationTests {

	@Autowired
	private OrdService ordService;

	@MockBean
	private OrdRepository ordRepository;

	@Test
	public void saveOrdDetails(){

		Ord ord = new Ord();
		ord.SetId(1L);
		ord.SetCustomerName("John Doe");
		ord.SetOrdDate(LocalDate.of(2010, 1, 1));
		ord.SetTotalAmount(100);

		when(ordRepository.save(ord)).thenReturn(ord);

		Ord saveOrd = ordService.setOrd(ord);

		assertNotNull(saveOrd);
		Assertions.assertEquals(saveOrd.getCustomerName(), "John Doe");
		Assertions.assertEquals(saveOrd.getOrdDate(), LocalDate.of(2010, 1, 1));
		Assertions.assertEquals(saveOrd.getTotalAmount(), 100);

		verify(ordRepository, times(1)).save(ord);
	}

	@Test
    public void getOrdDetails(){
		Ord o=new Ord();
		o.SetId(1L);
		o.SetCustomerName("Chinmay");
		o.SetOrdDate(LocalDate.of(2025,1,2));
		o.SetTotalAmount(200);

		List<Ord>orders=new ArrayList<>();
		orders.add(o);

		when(ordRepository.findAll()).thenReturn((orders));

		List<OrdDto> ord = ordService.getOrd();

		verify(ordRepository,times(1)).findAll();
	}

}
