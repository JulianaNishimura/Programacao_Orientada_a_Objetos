package org.example.extraExercises.ex1;

import java.util.Locale;

public	class	Principal	{
    public	static	void	main(String[]	args)	{
        Ingresso[]	ingressos	=	{
                new	Ingresso("Rock	in	Rio",	300.0),
                new	IngressoMeia("Rock	in	Rio",	300.0,	"RG-1234"),
                new	IngressoVip("Rock	in	Rio",	300.0,	50.0),
                new	IngressoCamarote("Rock	in	Rio",	300.0,	50.0)
        };

        double	total	=	0;
        for	(Ingresso	ingresso	:	ingressos)	{
            System.out.println(ingresso);
            System.out.println(String.format(Locale.US,	"		valor	final	=	%.2f",	ingresso.valorFinal()));
            total	+=	ingresso.valorFinal();
        }
        System.out.println(String.format(Locale.US,	"Total	=	%.2f",	total));
    }
}
