<?php
	//cria um array contendo 3 empregados 
	$casa = array('comodos' => array( 
		array( 
			'nome' => 'Sala', 
			'porta' => 0, 
			'lampada' => 0, 
		),
		array( 
			'nome' => 'Teste123', 
			'porta' => 0,
			'lampada' => 0, 
		),
		array( 
			'nome' => 'Quarto', 
			'porta' => 0, 
			'lampada' => 0 ,
		))); 

	//converte o conteúdo do array para uma string JSON 
	$json_str = json_encode($casa); 

	//imprime a string JSON 
	echo "$json_str"; 
?>
