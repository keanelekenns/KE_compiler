.class public test8
.super java/lang/Object

.method public static weird_function(ZICLjava/lang/String;FF)[I
    .limit locals 8
    .limit stack 50
;       T6 := NEWARRAY I 100
    ldc 100
    newarray int
    astore 6
;       T7 := "THIS IS FINE"
    ldc "THIS IS FINE"
    astore 7
;       PRINTU T7
    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 7
    invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
;       RETURN T6
    aload 6
    areturn
.end method


.method public static __main()V
    .limit locals 0
    .limit stack 50
;       RETURN
    return
.end method


;--------------------------------------------;
;                                            ;
; Boilerplate                                ;
;                                            ;
;--------------------------------------------;
.method public static main([Ljava/lang/String;)V
    ; set limits used by this method
    .limit locals 1
    .limit stack 4
    invokestatic test8/__main()V
    return
.end method

; standard initializer
.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method