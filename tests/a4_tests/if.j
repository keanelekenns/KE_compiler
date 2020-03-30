.class public if
.super java/lang/Object

.method public static less(II)V
    .limit locals 5
    .limit stack 50
;       T2 := T0 I< T1
    iload 0
    iload 1
    isub
    iflt L_0
    ldc 0
    goto L_1
L_0:
    ldc 1
L_1:
    istore 2
;       T3 := Z! T2
    iload 2
    ifne L_2
    iconst_1
    goto L_3
L_2:
    iconst_0
L_3:
    istore 3
;       IF T3 GOTO L0
    iload 3
    ifne L0
;       PRINTI T0
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 0
    invokevirtual java/io/PrintStream/print(I)V
;       T4 := " is less than "
    ldc " is less than "
    astore 4
;       PRINTU T4
    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 4
    invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
;       L0:
L0:
;       PRINTLNI T1
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 1
    invokevirtual java/io/PrintStream/println(I)V
    return
.end method


.method public static __main()V
    .limit locals 2
    .limit stack 50
;       T0 := 2
    ldc 2
    istore 0
;       T1 := 3
    ldc 3
    istore 1
;       CALL less(T0T1)
    iload 0
    iload 1
    invokestatic if/less(II)V
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
    invokestatic if/__main()V
    return
.end method

; standard initializer
.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method