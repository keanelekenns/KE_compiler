.class public test13
.super java/lang/Object

.method public static foo(IF)I
    .limit locals 2
    .limit stack 50
;       RETURN T0
    iload 0
    ireturn
.end method


.method public static draw_picture()V
    .limit locals 4
    .limit stack 50
;       T0 := "!_!"
    ldc "!_!"
    astore 0
;       PRINTU T0
    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 0
    invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
;       T1 := "_!_"
    ldc "_!_"
    astore 1
;       PRINTU T1
    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 1
    invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
;       T2 := " ! "
    ldc " ! "
    astore 2
;       PRINTU T2
    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 2
    invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
;       T3 := "} {"
    ldc "} {"
    astore 3
;       PRINTU T3
    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 3
    invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
    return
.end method


.method public static __main()V
    .limit locals 13
    .limit stack 50
;       T5 := 12
    ldc 12
    istore 5
;       T0 := T5
    iload 5
    istore 0
;       T6 := 23.3
    ldc 23.3
    fstore 6
;       T1 := T6
    fload 6
    fstore 1
;       T7 := 's'
    ldc 115
    istore 7
;       T2 := T7
    iload 7
    istore 2
;       T8 := "hello"
    ldc "hello"
    astore 8
;       T3 := T8
    aload 8
    astore 3
;       T9 := TRUE
    ldc 1
    istore 9
;       T4 := T9
    iload 9
    istore 4
;       T10 := 23
    ldc 23
    istore 10
;       T11 := T0 I+ T10
    iload 0
    iload 10
    iadd
    istore 11
;       T0 := T11
    iload 11
    istore 0
;       T12 := Z! T4
    iload 4
    ifne L_0
    iconst_1
    goto L_1
L_0:
    iconst_0
L_1:
    istore 12
;       IF T12 GOTO L0
    iload 12
    ifne L0
;       RETURN
    return
;       L0:
L0:
;       PRINTLNU T3
    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 3
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
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
    invokestatic test13/__main()V
    return
.end method

; standard initializer
.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method