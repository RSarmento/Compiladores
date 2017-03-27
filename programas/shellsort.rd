vet int ShellSort (vet int entrada[10]){
	int i, auxiliar, tamanho = 10, d = 10, booleano = 1;
	enquanto (booleano || d >= 1){
		booleano = 0;
		d = (d+1/2);
		para (i=0; i < tamanho, i = i+1){
			se (entrada[i+d]>entrada[i]){
				auxiliar = entrada[i+d];
				entrada[i+d]=entrada[i];
				entrada[i]=auxiliar;
				booleano=1;
			}
		}
	}
	retorne (entrada[]);
}

int inicio(){
	vet int entrada[10];
	imprimir(i=1;i<=10;i=i+1){
		ler(entrada[i]);
	}
	ShellSort(entrada[])
	para(i=1;i<=10;i=i+1){
		imprimir (entrada[i]);
	}
}
