int Fibonacci (int numero_termos){ 
	int i, soma_total, a, b; 
	soma_total = 0; 
	a = 1; 
	b = 1; 
	para (i = 1; i<numero_termos, i = i +1){ 
		b = a; 
		a =  soma_total; 
		soma_total = a + b; 
		imprimir ( soma_total); 
	} 
	retorne soma_total; 
} 
