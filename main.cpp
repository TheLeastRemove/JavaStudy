   void foo(int a,int&b,int*c){
    a++;b++;(*c)++
   }
   int a=1,b=2,c=3;
   foo(a,b,&c);
   cout<<a<<b<<c;